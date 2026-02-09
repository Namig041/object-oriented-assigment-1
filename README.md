# object-oriented-assigment-1
Random Number Generator Analysis

Name: Namig Amralizada
Student ID: 14042
Project: Random Number Generator Analysis
Language: Java

 Project Description

This project implements a Java program that generates random double values in the range [0, 1) using three different built-in Java random number generators:

java.util.Random

Math.random()

java.util.concurrent.ThreadLocalRandom

For selected sample sizes, the program analyzes the generated values using descriptive statistics, including:

Number of elements (n)

Mean

Sample standard deviation

Minimum value

Maximum value

The results are displayed in a tabular format in the console.

 Program Structure

The program consists of a single Java class named Generator and includes the following methods:

populate(int n, int randNumGen)
Generates n random values using the specified random number generator.

statistics(ArrayList<Double> randomValues)
Computes and returns statistical values in the order:
[n, mean, stddev, min, max]

display(ArrayList<Double> results, boolean headerOn)
Displays the statistical results in a formatted table.

execute()
Runs the experiment for all combinations of sample sizes and random number generators.

The main() method is minimal and only calls execute().

How to Compile and Run
Using Command Line

Open a terminal or command prompt.

Navigate to the folder containing Generator.java.

Compile the program:

javac Generator.java


Run the program:

java Generator

Using an IDE

Open the project in an IDE such as IntelliJ, Eclipse, NetBeans, or VS Code.

Run the Generator class.

Output will appear in the console.

Expected Output Behavior

A total of 9 result rows are displayed
(3 sample sizes × 3 random number generators)

As sample size increases:

Mean approaches 0.5

Standard deviation approaches 0.29

Minimum approaches 0

Maximum approaches 1

Results vary between runs due to randomness.

Files Included

Generator.java – Main Java source file

README.md – Project documentation
