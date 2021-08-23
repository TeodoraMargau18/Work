USE gamesbackend;

INSERT INTO players (
    player_age,
    player_birthdate,
    player_full_name,
    player_gender,
    player_is_online
)
VALUES
    (21,'2020-03-01', 'Alice Jones', 'FEMALE', FALSE),
    (22,'2019-03-05', 'John Doe', 'MALE', TRUE),
    (19,'2021-11-07', 'Dark Vader', 'MALE', TRUE),
    (20,'2020-03-07', 'June Spring', 'FEMALE', TRUE);


INSERT INTO billing_address (city, street, player_id)
VALUES
    ('Bucharest','Calea Victoriei 1', 1),
    ('Bucharest','Blvd Dacia 53', 2);


INSERT INTO games (game_name, game_type)
VALUES
    ('WoW',2),
    ('Star Wars',0),
    ('Civilisation',3);

