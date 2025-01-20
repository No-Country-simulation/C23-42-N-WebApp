CREATE TABLE IF NOT EXISTS playlists
(
id INT AUTO_INCREMENT PRIMARY KEY,
name VARCHAR(50) NOT NULL,
cover_picture VARCHAR(255) DEFAULT 'public/images/defaultCoverPicturePlaylist.jpg',
user_id INT NOT NULL,
created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
updated_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
is_active TINYINT(1) DEFAULT 1,
FOREIGN KEY (user_id) REFERENCES users(id)
)