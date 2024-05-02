DROP TABLE board;

CREATE TABLE `board` (
  `no` int NOT NULL AUTO_INCREMENT,
  `title` varchar(100) NOT NULL,
  `writer` varchar(100) NOT NULL,
  `content` text,
  `reg_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `upd_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `views` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`no`)
) COMMENT='게시판';

DROP TABLE file;

CREATE TABLE `file` (
  `no` int NOT NULL AUTO_INCREMENT,
  `parent_table` varchar(45) NOT NULL,
  `parent_no` int NOT NULL,
  `file_name` text NOT NULL,
  `origin_name` text,
  `file_path` text NOT NULL,
  `file_size` int NOT NULL DEFAULT '0',
  `reg_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `upd_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `file_code` int NOT NULL DEFAULT '0',         
  PRIMARY KEY (`no`)
) COMMENT='파일';

TRUNCATE board;
TRUNCATE file;

-- board, file 테이블 조인 조회
SELECT b.*
      ,f.no file_no
      ,f.file_name
      ,f.file_path
      ,f.file_code
FROM board b LEFT JOIN (  
                          SELECT *
                          FROM file
                          WHERE parent_table = "board"
                            AND file_code = 1
                        ) f
             ON (b.no = f.parent_no)
-- WHERE f.parent_table = "board"
--   AND f.file_code = 1
                                  # file_code = 1 (대표 썸네일)
;

-- 게시글 목록 페이징

SELECT *
FROM board
LIMIT #{index},#{rows}
;

INSERT INTO board(title, writer, content) 
VALUES 
  ('제목01', '작성자01', '내용01'),
  ('제목02', '작성자02', '내용02'),
  ('제목03', '작성자03', '내용03'),
  ('제목04', '작성자04', '내용04'),
  ('제목05', '작성자05', '내용05'),
  ('제목06', '작성자06', '내용06'),
  ('제목07', '작성자07', '내용07'),
  ('제목08', '작성자08', '내용08'),
  ('제목09', '작성자09', '내용09'),
  ('제목10', '작성자10', '내용10'),
  ('제목11', '작성자11', '내용11'),
  ('제목12', '작성자12', '내용12'),
  ('제목13', '작성자13', '내용13'),
  ('제목14', '작성자14', '내용14'),
  ('제목15', '작성자15', '내용15'),
  ('제목16', '작성자16', '내용16'),
  ('제목17', '작성자17', '내용17'),
  ('제목18', '작성자18', '내용18'),
  ('제목19', '작성자19', '내용19'),
  ('제목20', '작성자20', '내용20'),
  ('제목21', '작성자21', '내용21'),
  ('제목22', '작성자22', '내용22'),
  ('제목23', '작성자23', '내용23'),
  ('제목24', '작성자24', '내용24'),
  ('제목25', '작성자25', '내용25'),
  ('제목26', '작성자26', '내용26'),
  ('제목27', '작성자27', '내용27'),
  ('제목28', '작성자28', '내용28'),
  ('제목29', '작성자29', '내용29'),
  ('제목30', '작성자30', '내용30'),
  ('제목31', '작성자31', '내용31'),
  ('제목32', '작성자32', '내용32'),
  ('제목33', '작성자33', '내용33'),
  ('제목34', '작성자34', '내용34'),
  ('제목35', '작성자35', '내용35'),
  ('제목36', '작성자36', '내용36'),
  ('제목37', '작성자37', '내용37'),
  ('제목38', '작성자38', '내용38'),
  ('제목39', '작성자39', '내용39'),
  ('제목40', '작성자40', '내용40'),
  ('제목41', '작성자41', '내용41'),
  ('제목42', '작성자42', '내용42'),
  ('제목43', '작성자43', '내용43'),
  ('제목44', '작성자44', '내용44'),
  ('제목45', '작성자45', '내용45'),
  ('제목46', '작성자46', '내용46'),
  ('제목47', '작성자47', '내용47'),
  ('제목48', '작성자48', '내용48'),
  ('제목49', '작성자49', '내용49'),
  ('제목50', '작성자50', '내용50'),
  ('제목51', '작성자51', '내용51'),
  ('제목52', '작성자52', '내용52'),
  ('제목53', '작성자53', '내용53'),
  ('제목54', '작성자54', '내용54'),
  ('제목55', '작성자55', '내용55'),
  ('제목56', '작성자56', '내용56'),
  ('제목57', '작성자57', '내용57'),
  ('제목58', '작성자58', '내용58'),
  ('제목59', '작성자59', '내용59'),
  ('제목60', '작성자60', '내용60'),
  ('제목61', '작성자61', '내용61'),
  ('제목62', '작성자62', '내용62'),
  ('제목63', '작성자63', '내용63'),
  ('제목64', '작성자64', '내용64'),
  ('제목65', '작성자65', '내용65'),
  ('제목66', '작성자66', '내용66'),
  ('제목67', '작성자67', '내용67'),
  ('제목68', '작성자68', '내용68'),
  ('제목69', '작성자69', '내용69'),
  ('제목70', '작성자70', '내용70'),
  ('제목71', '작성자71', '내용71'),
  ('제목72', '작성자72', '내용72'),
  ('제목73', '작성자73', '내용73'),
  ('제목74', '작성자74', '내용74'),
  ('제목75', '작성자75', '내용75'),
  ('제목76', '작성자76', '내용76'),
  ('제목77', '작성자77', '내용77'),
  ('제목78', '작성자78', '내용78'),
  ('제목79', '작성자79', '내용79'),
  ('제목80', '작성자80', '내용80');


-- 댓글
-- * 게시글(board)에 종속된 테이블
CREATE TABLE reply (
  no            INT NOT NULL AUTO_INCREMENT PRIMARY KEY,      -- 댓글번호
  board_no      INT NOT NULL,                                 -- 글번호  
  parent_no     INT NOT NULL,                                 -- 부모번호
  writer        VARCHAR(100) NOT NULL,                        -- 작성자
  content       TEXT NOT NULL,                                -- 내용
  reg_date      TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP, -- 등록일자
  upd_date      TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP  -- 수정일자
);

INSERT INTO reply (board_no, parent_no, writer, content)
VALUES (140, 0, '김조은', '댓글 내용1'),
        (140, 0, '김조은', '댓글 내용2'),
        (140, 0, '김조은', '댓글 내용3'),
        (140, 0, '김조은', '댓글 내용4'),
        (140, 0, '김조은', '댓글 내용5')
        ;