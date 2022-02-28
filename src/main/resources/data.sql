

INSERT INTO post(id,user_id, music_name, artist_name, genre_id, caption,created)
VALUES(1,1, '一途', 'King gnu', 1 , 'ロックバンドです。','2021-12-03 12:00:00');


INSERT INTO user(id,name, email, password)
VALUES(1,'TARO', 'taro@taro.com', 'tarotarotaro');


INSERT INTO postComment(id,post_id, user_id, comment, created)
VALUES(1, 1, 1, 'Good', '2022-02-22 12:00:00');


INSERT INTO genreType(id,genre)
VALUES(1, 'ROCK'),(2, 'JPOP'),(3, 'HIPHOP'),(4, 'KPOP'),(5, 'EDM');