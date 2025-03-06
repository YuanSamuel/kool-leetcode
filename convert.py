import re
import sys

def java_to_kool(java_code: str) -> str:
    java_code = java_code.replace("\\n", "\n")
    kool_lines = []
    # Process the Java code line-by-line
    for line in java_code.splitlines():
        # Skip package declarations
        if line.strip().startswith("package"):
            continue

        # Remove visiblity keywords from class and methods
        line = re.sub(r'\bpublic\s+', '', line)
        line = re.sub(r'\bprivate\s+', '', line)
        line = re.sub(r'\bprotected\s+', '', line)

        # Remove "static" keyword in method declarations
        line = re.sub(r'\bstatic\s+', '', line)

        # Convert the main method signature:
        # Replace: void main(String[] args) {  with: method Main() {
        if re.search(r'\bvoid\s+main\s*\(\s*String\[\]\s*\w+\s*\)', line):
            indent = re.match(r'\s*', line).group(0)
            line = indent + "method Main() {"

        # Replace System.out.println with print
        line = line.replace("System.out.println", "print")

        # Convert "boolean" to "bool"
        line = line.replace("boolean", "bool")

        # Transform compound math operators (e.g. +=, -=, *=, /=, %=)
        line = re.sub(
            r'(\S+)\s*([\+\-\*/%])=\s*(.+);',
            lambda m: f"{m.group(1)} = {m.group(1)} {m.group(2)} {m.group(3)};",
            line
        )

        # Transform array initializations:
        # e.g. "int[] dp = new int[n + 1];" -> "int dp[n + 1];"
        line = re.sub(
            r'(\w+)\[\]\s+(\w+)\s*=\s*new\s+\w+\s*(\[[^;]+\])\s*;',
            r'\1 \2\3;',
            line
        )

        kool_lines.append(line)
    
    return "\n".join(kool_lines)

def convert_java_file_to_string(input_path):
    """
    Reads a Java source file, replaces actual newline characters with the literal "\n" string,
    and writes the resulting string to an output file.
    
    Args:
        input_path (str): The path to the input Java file.
        output_path (str): The path to the output file.
    """
    # Read the contents of the Java file
    with open(input_path, "r") as file:
        content = file.read()

    # Replace each actual newline with the literal "\n"
    content_with_escaped_newlines = content.replace("\n", "\\n")

    return content_with_escaped_newlines

if __name__ == "__main__":
    file_path = sys.argv[1] if len(sys.argv) > 1 else "input.java"

    # Open the file in read mode and read its contents into a string
    with open(file_path, "r") as file:
        java_code = file.read()

    java_code_string = convert_java_file_to_string(file_path)
    print(java_code_string)
    
    kool_code = java_to_kool(java_code)

    # Save the converted Kool code to a new file
    output_file_path = file_path.replace(".java", ".kool")

    # Add "generated" as folder before the file name, file_path may have other folders
    output_file_path = output_file_path.replace(file_path.split("/")[-1], "generated/" + file_path.split("/")[-1])

    with open(output_file_path, "w") as output_file:
        output_file.write(kool_code)
    print(f"Converted code saved to {output_file_path}")
