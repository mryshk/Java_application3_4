
 
 CREATE TABLE IF NOT EXISTS post(
    post_id int(2) AUTO_INCREMENT PRIMARY KEY,
    user_id int(2) NOT NULL,
    music_name VARCHAR(100),
    artist_name VARCHAR(100) ,
    genre int(1),
    caption VARCHAR(200) NOT NULL,
    created DATETIME
 );
 
