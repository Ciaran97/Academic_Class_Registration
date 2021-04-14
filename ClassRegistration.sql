CREATE DATABASE GenesysClassRegistration

CREATE TABLE Professors(
Id INT PRIMARY KEY IDENTITY(1, 1), 
Name VARCHAR(100) NOT NULL, 
Surname VARCHAR(100) NOT NULL, 
date_of_birth DATE NOT NULL
)

CREATE TABLE Courses(
Id INT PRIMARY KEY IDENTITY(1, 1), 
Course_Name VARCHAR(MAX) NOT NULL, 
Course_Code VARCHAR(10) NOT NULL, 
Professor_Id INT NULL FOREIGN KEY REFERENCES Professors(Id)
)

CREATE TABLE Students(
Id INT PRIMARY KEY IDENTITY(1, 1), 
Name VARCHAR(100) NOT NULL, 
Surname VARCHAR(100) NOT NULL, 
Date_Of_Birth DATE NOT NULL
)

CREATE TABLE Student_Courses(
Student_Id INT NOT NULL FOREIGN KEY REFERENCES Students(Id), 
Course_Id INT NOT NULL FOREIGN KEY REFERENCES Courses(Id)
)


/*Professors dummy data*/
INSERT INTO Professors(Name, Surname, Date_Of_Birth)
VALUES('John', 'Starman', '1985-10-25')

INSERT INTO Professors(Name, Surname, Date_Of_Birth)
VALUES('David', 'Villiers', '1989-9-22')

INSERT INTO Professors(Name, Surname, Date_Of_Birth)
VALUES('Sean', 'Mccoy', '1991-1-18')

INSERT INTO Professors(Name, Surname, Date_Of_Birth)
VALUES('Albus', 'Dumbledor', '1685-5-14')

INSERT INTO Professors(Name, Surname, Date_Of_Birth)
VALUES('Karen', 'Rollery', '1987-4-9')

/* Courses dummy data*/
INSERT INTO Courses(Course_Name, Course_Code, Professor_Id)
VALUES('Defense Against the Dark Arts', 'DADA4582', 1)

INSERT INTO Courses(Course_Name, Course_Code, Professor_Id)
VALUES('Potions', 'POTS7594', 2)

INSERT INTO Courses(Course_Name, Course_Code, Professor_Id)
VALUES('Magical Creatures', 'MGCR9547', 3)

INSERT INTO Courses(Course_Name, Course_Code, Professor_Id)
VALUES('Programming', 'PROG6212',4)

INSERT INTO Courses(Course_Name, Course_Code, Professor_Id)
VALUES('Open Source Coding', 'OPSC7312', 5)

/*Student Dummy Data*/
INSERT INTO Students(Name, Surname, Date_Of_Birth)
VALUES('Ciaran', 'Swanepoel', '1997-09-25')

INSERT INTO Students(Name, Surname, Date_Of_Birth)
VALUES('Alexa', 'Anniciello', '1999-08-11')

INSERT INTO Students(Name, Surname, Date_Of_Birth)
VALUES('Brydon', 'Johnstone', '1997-09-22')

INSERT INTO Students(Name, Surname, Date_Of_Birth)
VALUES('Tyrrell', 'Mentoor', '1997-04-12')

INSERT INTO Students(Name, Surname, Date_Of_Birth)
VALUES('Paolo', 'Bonovera', '1994-10-18')

INSERT INTO Students(Name, Surname, Date_Of_Birth)
VALUES('Alexis', 'Tzelios', '1993-01-11')

INSERT INTO Students(Name, Surname, Date_Of_Birth)
VALUES('Wayne', 'Stevens', '1996-09-18')

INSERT INTO Students(Name, Surname, Date_Of_Birth)
VALUES('Kevin', 'Van Wyk', '1997-04-16')