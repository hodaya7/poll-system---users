# poll-system---users
user service of poll system.
the polls service in https://github.com/hodaya7/poll-system---polls.git

Project Overview
Polls System is designed to create a platform where a company can ask its customers various questions, analyze the responses, and generate statistics about the data. The system includes separate services for managing users, questions, and poll answers. This implementation includes three main REST APIs: Users, Questions, and Poll Answers, each with full CRUD operations.

Pay attention to the sdk ![image](https://github.com/user-attachments/assets/e0d68568-b325-468b-9223-5cdd78a9b64c)

API
that implement the following:
-in the question controller ● By passing the question id → Return how many users choose each of 
the question options, and the question itself + possible answers
-in question ● By passing the question id → Return how many users answer to this 
question in total, and the question itself
-in answer ● By passing the user id → Return the user answer to each question he 
submitted, and the user-name and the title of each quesiton
-in answer ● By passing the user id → Return how many questions this user 
answered to, and the user name
in answer ● Return all questions and for each question how many users choose 
each of the question options, and the question title, and each option
