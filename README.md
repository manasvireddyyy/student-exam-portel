# Student Exam Portal

The **Student Exam Portal** is a full-stack web application designed to simplify the process of conducting and managing student exams. It enables administrators to create exams, upload questions, and monitor results, while students can securely attempt exams and view their scores.

## 🌟 Key Features

- 🔐 Student and Admin Authentication
- 📝 Exam creation and management by Admin
- 🧠 MCQ/Short Answer-based Online Exams
- ⚡ Automatic scoring and evaluation
- 📊 Result generation and report viewing
- 📦 Secure database storage using MongoDB

## 🛠️ Tech Stack

- **Frontend**: HTML, CSS, JavaScript
- **Backend**: Node.js, Express.js
- **Database**: MongoDB
- **Version Control**: Git & GitHub

## 📁 Folder Structure

student-exam-portel/
├── client/ # Frontend files
├── server/ # Backend logic
│ ├── routes/ # Express routes
│ ├── models/ # Mongoose models
│ └── controllers/ # Business logic
├── .env # Environment variables
├── package.json # Dependencies
└── README.md


## 🚀 Getting Started

### Prerequisites

- Node.js and npm installed
- MongoDB (Local or Atlas)
- Git installed

### Installation Steps

1. Clone the repository:
   ```bash
   git clone https://github.com/manasvireddyyy/student-exam-portel.git
2. Navigate to the project:
   cd student-exam-portel/server
3. Install backend dependencies:
    npm install
4. Create a .env file in the server/ directory:
   MONGO_URI=your_mongodb_connection_string
   PORT=5000
5. Start the backend server:
   npm start
6. Open client/ in a browser or editor to edit frontend.
