CREATE TABLE health_data (
    id INT AUTO_INCREMENT PRIMARY KEY,
    employee_id INT,
    date_of_birth DATE,
    gender VARCHAR(10),
    blood_pressure VARCHAR(10),
    cholesterol_level FLOAT,
    blood_sugar_level FLOAT,
    weight FLOAT,
    height FLOAT
);

INSERT INTO health_data (employee_id, date_of_birth, gender, blood_pressure, cholesterol_level, blood_sugar_level, weight, height)
VALUES (1, '1990-05-15', 'Male', '120/80', 5.2, 90.5, 70.2, 175.5),
       (2, '1985-09-20', 'Female', '130/85', 4.8, 95.2, 65.8, 160.2),
       (3, '1992-02-10', 'Male', '140/90', 5.5, 100.1, 80.3, 180.0);

    CREATE TABLE recruitment_data (
        id INT AUTO_INCREMENT PRIMARY KEY,
        job_title VARCHAR(100),
        department VARCHAR(100),
        experience_years INT,
        qualification VARCHAR(100),
        salary DECIMAL(10, 2),
        start_date DATE,
        end_date DATE
    );

    INSERT INTO recruitment_data (job_title, department, experience_years, qualification, salary, start_date, end_date)
    VALUES ('Software Engineer', 'Engineering', 3, 'Bachelor's Degree', 5000.00, '2022-01-01', '2022-12-31'),
           ('Sales Manager', 'Sales', 5, 'Master's Degree', 8000.00, '2022-02-01', '2022-12-31'),
           ('HR Specialist', 'Human Resources', 2, 'Bachelors Degree', 4000.00, '2022-03-01', '2022-12-31');

CREATE TABLE applicantstable (
    id INT AUTO_INCREMENT PRIMARY KEY,
    applicant_name VARCHAR(100);
    job_title VARCHAR(100),
    department VARCHAR(100),
    experience_years INT,
    qualification VARCHAR(100),
    linktoresume VARCHAR(200),
    onlineassessmentscore INT,
    roundonescore INT,
    roundtwoscore INT,
    roundthreescore INT,
)

INSERT INTO applicantstable (applicant_name, job_title, department, experience_years, qualification, linktoresume, onlineassessmentscore, roundonescore, roundtwoscore, roundthreescore, applicationdecision)
VALUES ("John Doe", "Software Engineer", "Engineering", 3, "Bachelor's Degree", "https://example.com/resume", 80, 90, 85, 95, 0),
       ("Jane Smith", "Sales Manager", "Sales", 5, "Master's Degree", "https://example.com/resume", 75, 85, 80, 90, 1),
       ("Mike Johnson", "HR Specialist", "Human Resources", 2, "Bachelor's Degree", "https://example.com/resume", 70, 80, 75, 85, -1);

    ALTER TABLE applicantstable
    ADD COLUMN applicationdecision INT DEFAULT 0;
