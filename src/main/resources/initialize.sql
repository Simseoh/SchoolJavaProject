INSERT INTO users (user_id, name, email) VALUES(1, '김철수', 'chs@gmail.com');
INSERT INTO users (user_id, name, email) VALUES(2, '신짱구', 'jj9@gmail.com');
INSERT INTO users (user_id, name, email) VALUES(3, '맹구', 'mg@gmail.com');

INSERT INTO items (item_id, title, description, price, sellor_id) VALUES (1, '자전거', '오래됨', 20000, 1);
INSERT INTO items (item_id, title, description, price, sellor_id) VALUES (2, '연필', '토끼 모양', 10000, 1);
INSERT INTO items (item_id, title, description, price, sellor_id) VALUES (3, '필통', '필?통', 30000, 2);
INSERT INTO items (item_id, title, description, price, sellor_id) VALUES (4, '충전기', '고장남', 50000, 2);
INSERT INTO items (item_id, title, description, price, sellor_id) VALUES (5, '휴대폰', '공폰', 5000, 3);
INSERT INTO items (item_id, title, description, price, sellor_id) VALUES (6, '책상', '일체형', 24000, 3);

INSERT INTO item_comments (comment_id, author_id, content, item_id) VALUES (1, 1, '좋네요', 1);
INSERT INTO item_comments (comment_id, author_id, content, item_id) VALUES (2, 2, '별로에요', 2);
INSERT INTO item_comments (comment_id, author_id, content, item_id) VALUES (3, 3, '네고 좀', 3);
INSERT INTO item_comments (comment_id, author_id, content, item_id) VALUES (4, 2, '안사요', 4);
INSERT INTO item_comments (comment_id, author_id, content, item_id) VALUES (5, 1, '뭐임', 5);