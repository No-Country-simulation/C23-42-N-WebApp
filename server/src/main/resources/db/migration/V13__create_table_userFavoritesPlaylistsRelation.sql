CREATE TABLE IF NOT EXISTS user_favorites_playlists_relation
(
id INT AUTO_INCREMENT PRIMARY KEY,
user_id INT NOT NULL,
playlist_id INT NOT NULL,
created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
FOREIGN KEY (user_id) REFERENCES users(id),
FOREIGN KEY (playlist_id) REFERENCES playlists(id)
)