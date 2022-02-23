
 
 CREATE TABLE IF NOT EXISTS post(
    id int(2) AUTO_INCREMENT PRIMARY KEY,
    user_id int(2) NOT NULL,
    music_name VARCHAR(100),
    artist_name VARCHAR(100) ,
    genre int(1),
    caption VARCHAR(200) NOT NULL,
    created DATETIME
 );
 
CREATE TABLE user(
    id int(2) AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL,
    password VARCHAR(100) NOT NULL
  );
  
CREATE TABLE postComment(
    id int(2) AUTO_INCREMENT PRIMARY KEY,
    post_id int(2),
    user_id int(2),
    comment TEXT NOT NULL,
    created DATETIME
  );