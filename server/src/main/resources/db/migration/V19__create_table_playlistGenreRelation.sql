CREATE TABLE IF NOT EXISTS playlist_genre_relation
(
id INT AUTO_INCREMENT PRIMARY KEY,
playlist_id INT NOT NULL,
genre_id INT NOT NULL,
FOREIGN KEY (playlist_id) REFERENCES playlists(id),
FOREIGN KEY (genre_id) REFERENCES genres(id)
)