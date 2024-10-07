import os
import json

# Path to your LeetCode repository
repo_path = './'

# Read the questions from questions.txt
with open("questions.txt", "r", encoding="utf-8") as file:
    questions = file.read().strip().split("\n")

# Function to convert question name to folder format
def format_folder(question_number, question_name):
    formatted_name = question_name.lower().replace(' ', '-')
    folder_name = f"{int(question_number):04d}-{formatted_name}"
    return folder_name

# Function to generate LeetCode URL
def generate_question_link(question_name):
    formatted_name = question_name.lower().replace(' ', '-')
    question_url = f"https://leetcode.com/problems/{formatted_name}/description/"
    return question_url

# Function to add color for difficulty
def difficulty_color(difficulty):
    if difficulty == "Easy":
        return '<span style="color: green;">Easy</span>'
    elif difficulty == "Medium":
        return '<span style="color: orange;">Medium</span>'
    else:
        return '<span style="color: red;">Hard</span>'

# Function to generate markdown-based progress bar
def generate_markdown_progress_bar(progress):
    filled_blocks = "█" * (progress // 5)
    empty_blocks = "░" * (20 - len(filled_blocks))
    return f"[{filled_blocks}{empty_blocks}] {progress}%"

# Initialize counters
total_questions = len(questions) // 3
solved_questions = 0
question_data = []

# Prepare README.md with UTF-8 encoding
with open("README.md", "w", encoding="utf-8") as readme:
    readme.write("# LeetCode Progress\n\n")

    # Process the questions
    for i in range(0, len(questions), 3):  # Each question has 3 lines (name, acceptance, difficulty)
        question_name = questions[i].split('. ')[1]
        question_number = questions[i].split('. ')[0]
        acceptance_rate = questions[i+1]
        difficulty = questions[i+2]

        # Generate folder name
        folder_name = format_folder(question_number, question_name)
        
        # Check if the folder exists (i.e., if the question is solved)
        folder_exists = os.path.isdir(os.path.join(repo_path, folder_name))
        if folder_exists:
            solved_questions += 1

        # Add to JSON data
        question_data.append({
            "number": question_number,
            "name": question_name,
            "acceptance_rate": acceptance_rate,
            "difficulty": difficulty,
            "tags": [],  # Empty list for tags, can be populated later
            "companies": []  # Empty list for companies, can be populated later
        })

# Calculate progress percentage
progress_percentage = int((solved_questions / total_questions) * 100)

# Write the progress bar and solved questions count at the top of README
with open("README.md", "w", encoding="utf-8") as readme:
    readme.write("# LeetCode Progress\n\n")
    readme.write(f"### Solved: {solved_questions}/{total_questions}\n\n")
    
    # Insert Markdown progress bar
    progress_bar_md = generate_markdown_progress_bar(progress_percentage)
    readme.write(progress_bar_md + "\n\n")

    # Table header
    readme.write("| #   | Question       | Acceptance Rate | Difficulty |\n")
    readme.write("|-----|----------------|-----------------|------------|\n")

    # Write all question info to README
    for i in range(0, len(questions), 3):
        question_name = questions[i].split('. ')[1]
        question_number = questions[i].split('. ')[0]
        acceptance_rate = questions[i+1]
        difficulty = questions[i+2]

        # Generate folder name
        folder_name = format_folder(question_number, question_name)

        # Check if the folder exists (i.e., if the question is solved)
        folder_exists = os.path.isdir(os.path.join(repo_path, folder_name))
        checkbox = "✔️" if folder_exists else "❌"

        # Generate question link
        question_link = generate_question_link(question_name)
        
        # Add the colored difficulty
        colored_difficulty = difficulty_color(difficulty)

        # Write question info to README in table format with a clickable link
        readme.write(f"| {question_number} | {checkbox} [{question_name}]({question_link}) | {acceptance_rate} | {colored_difficulty} |\n")

# Save the question data to a JSON file
with open("questions.json", "w", encoding="utf-8") as json_file:
    json.dump(question_data, json_file, indent=4)

# Optional: If you'd rather have a YAML file, you can use the following code (requires PyYAML)
# import yaml
# with open("questions.yml", "w", encoding="utf-8") as yaml_file:
#     yaml.dump(question_data, yaml_file, default_flow_style=False, allow_unicode=True)
