CREATE TABLE IF NOT EXISTS song_genre_relation
(
id INT AUTO_INCREMENT PRIMARY KEY,
song_id INT NOT NULL,
genre_id INT NOT NULL,
FOREIGN KEY (song_id) REFERENCES songs(id),
FOREIGN KEY (genre_id) REFERENCES genres(id)
)