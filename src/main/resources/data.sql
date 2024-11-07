
CREATE TABLE Ability (
    id_ability SERIAL PRIMARY KEY,
    name VARCHAR(255),
    type VARCHAR(255),
    effect VARCHAR(255),
    cooldown INT,
    duration INT,
    remainingCooldown INT DEFAULT 0,
    activeTurnsLeft INT DEFAULT 0
);

INSERT INTO Ability (name, type, effect, remainingCooldown, activeTurnsLeft) VALUES ('PowerfulBlow', 'Physical', 'Increases hero damage by 15', 3, 1);
INSERT INTO Ability (name, type, effect, remainingCooldown, activeTurnsLeft) VALUES ('ProtectiveShield', 'Defense', 'Reduces incoming damage by 5', 5, 2);

CREATE TABLE Aiden (
    id_aiden SERIAL PRIMARY KEY,
    name VARCHAR(255),
    life_points INT,
    attack_power INT,
    score INT
);
INSERT INTO Aiden (name, life_points, attack_power, score) VALUES ('Aiden', 100, 20, 0);

CREATE TABLE Villains (
    id SERIAL PRIMARY KEY,
    villano_type VARCHAR(255),
    life_points INT,
    attack_points INT
);

INSERT INTO Villains (villano_type, life_points, attack_points) VALUES ('Ghost', 15, 7);
INSERT INTO Villains (villano_type, life_points, attack_points) VALUES ('Skeleton', 10, 5);
INSERT INTO Villains (villano_type, life_points, attack_points) VALUES ('Vampire', 20, 10);

INSERT INTO Protectiveshield (name, type, effect, id_ability) VALUES ('Magic Barrier', 'Defense', 'Reduces incoming damage', 2);

CREATE TABLE Stage (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255),
    description TEXT,
    level INT
);

INSERT INTO Stage (name, description, level) VALUES ('Forest of Shadows', 'A dark and eerie forest', 1);

CREATE TABLE SkeletonGroup (
    id SERIAL PRIMARY KEY,number_of_skeletons INT,
    skeleton_group_id INT REFERENCES Villains(id)
);

INSERT INTO SkeletonGroup (number_of_skeletons, skeleton_group_id) VALUES (5, 1);

CREATE TABLE Object (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255),
    type VARCHAR(255),
    effect VARCHAR(255)
);

INSERT INTO Object (name, type, effect) VALUES ('Enchanted Sword', 'Weapon', 'Increases attack power');
INSERT INTO Object (name, type, effect) VALUES ('Health Potion', 'Healing', 'Restores health points');