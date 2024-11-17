import java.util.*;

public class Main {
    static class TaskCategory {
        String name;
        List<TaskCategory> subcategories;
        List<String> tasks;

        TaskCategory(String name) {
            this.name = name;
            this.subcategories = new ArrayList<>();
            this.tasks = new ArrayList<>();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TaskCategory root = null;

        System.out.println("To-Do List Manager");

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Create Main Category");
            System.out.println("2. Add Subcategory");
            System.out.println("3. Add Task");
            System.out.println("4. View To-Do List");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.print("Enter the main category name: ");
                    String categoryName = scanner.nextLine();
                    root = new TaskCategory(categoryName);
                    System.out.println("Main category created: " + categoryName);
                    break;

                case 2:
                    if (root == null) {
                        System.out.println("No main category found! Create one first.");
                    } else {
                        System.out.print("Enter parent category name: ");
                        String parentName = scanner.nextLine();
                        System.out.print("Enter subcategory name: ");
                        String subcategoryName = scanner.nextLine();
                        TaskCategory parent = findCategory(root, parentName);
                        if (parent != null) {
                            parent.subcategories.add(new TaskCategory(subcategoryName));
                            System.out.println("Subcategory '" + subcategoryName + "' added under '" + parentName + "'.");
                        } else {
                            System.out.println("Parent category not found.");
                        }
                    }
                    break;

                case 3:
                    if (root == null) {
                        System.out.println("No main category found! Create one first.");
                    } else {
                        System.out.print("Enter category name to add task: ");
                        String taskCategoryName = scanner.nextLine();
                        System.out.print("Enter task description: ");
                        String taskDescription = scanner.nextLine();
                        TaskCategory category = findCategory(root, taskCategoryName);
                        if (category != null) {
                            category.tasks.add(taskDescription);
                            System.out.println("Task added to '" + taskCategoryName + "'.");
                        } else {
                            System.out.println("Category not found.");
                        }
                    }
                    break;

                case 4:
                    if (root == null) {
                        System.out.println("No categories found! Create one first.");
                    } else {
                        System.out.println("\nTo-Do List:");
                        displayCategories(root, 0);
                    }
                    break;

                case 5:
                    System.out.println("Exiting program. Goodbye!");
                    return;

                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }

    private static TaskCategory findCategory(TaskCategory root, String name) {
        if (root == null) return null;
        if (root.name.equalsIgnoreCase(name)) return root;

        for (TaskCategory sub : root.subcategories) {
            TaskCategory found = findCategory(sub, name);
            if (found != null) return found;
        }
        return null;
    }

    private static void displayCategories(TaskCategory category, int depth) {
        if (category == null) return;
        System.out.println("  ".repeat(depth) + "- " + category.name);
        for (String task : category.tasks) {
            System.out.println("  ".repeat(depth + 1) + "* " + task);
        }
        for (TaskCategory sub : category.subcategories) {
            displayCategories(sub, depth + 1);
        }
    }
}