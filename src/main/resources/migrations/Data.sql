CREATE TABLE users { id TEXT PRIMARY KEY UNIQUE NOT NULL,
login TEXT UNIQUE NOT NULL,
password TEXT NOT NULL,
role TEXT NOT NULL }

INSERT INTO users (id, login, password, role)
VALUES (
        '',
        'adm',
        '$2a$10$YDZ.T//73qLAPKfzJ1MYpuCZqPc.DU4uCuUq1SmnDyRud.cf.YQEi',
        'ADMIN'
    ),

    -- @123456