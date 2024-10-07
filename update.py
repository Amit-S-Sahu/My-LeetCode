import os
import json

repo_path = './'

with open("questions.txt", "r", encoding="utf-8") as file:
    questions = file.read().strip().split("\n")

def format_folder(question_number, question_name):
    formatted_name = question_name.lower().replace(' ', '-')
    folder_name = f"{int(question_number):04d}-{formatted_name}"
    return folder_name

def generate_question_link(question_name):
    formatted_name = question_name.lower().replace(' ', '-')
    question_url = f"https://leetcode.com/problems/{formatted_name}/description/"
    return question_url

def difficulty_color(difficulty):
    if difficulty == "Easy":
        return '<span style="color: green;">Easy</span>'
    elif difficulty == "Medium":
        return '<span style="color: orange;">Medium</span>'
    else:
        return '<span style="color: red;">Hard</span>'

def generate_markdown_progress_bar(progress):
    filled_blocks = "█" * (progress // 5)
    empty_blocks = "░" * (20 - len(filled_blocks))
    return f"[{filled_blocks}{empty_blocks}] {progress}%"

total_questions = len(questions) // 3
solved_questions = 0
question_data = []

with open("README.md", "w", encoding="utf-8") as readme:
    readme.write("# LeetCode Progress\n\n")

    for i in range(0, len(questions), 3):  
        question_name = questions[i].split('. ')[1]
        question_number = questions[i].split('. ')[0]
        acceptance_rate = questions[i+1]
        difficulty = questions[i+2]

        folder_name = format_folder(question_number, question_name)
        
        folder_exists = os.path.isdir(os.path.join(repo_path, folder_name))
        if folder_exists:
            solved_questions += 1

        question_data.append({
            "number": question_number,
            "name": question_name,
            "acceptance_rate": acceptance_rate,
            "difficulty": difficulty,
            "tags": [],  
            "companies": []  
        })

progress_percentage = int((solved_questions / total_questions) * 100)

with open("README.md", "w", encoding="utf-8") as readme:
    readme.write("# LeetCode Progress\n\n")
    readme.write(f"### Solved: {solved_questions}/{total_questions}\n\n")
    
    progress_bar_md = generate_markdown_progress_bar(progress_percentage)
    readme.write(progress_bar_md + "\n\n")

    readme.write("| #   | Question       | Acceptance Rate | Difficulty |\n")
    readme.write("|-----|----------------|-----------------|------------|\n")

    for i in range(0, len(questions), 3):
        question_name = questions[i].split('. ')[1]
        question_number = questions[i].split('. ')[0]
        acceptance_rate = questions[i+1]
        difficulty = questions[i+2]

        folder_name = format_folder(question_number, question_name)

        folder_exists = os.path.isdir(os.path.join(repo_path, folder_name))
        checkbox = "✔️" if folder_exists else "❌"

        question_link = generate_question_link(question_name)
        
        colored_difficulty = difficulty_color(difficulty)

        readme.write(f"| {question_number} | {checkbox} [{question_name}]({question_link}) | {acceptance_rate} | {colored_difficulty} |\n")

with open("questions.json", "w", encoding="utf-8") as json_file:
    json.dump(question_data, json_file, indent=4)