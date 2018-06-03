package com.epam.task2.controller;

import com.epam.task2.entity.CompositeUnitEntity;
import com.epam.task2.logic.ParserLogic;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileReader;
import java.io.IOException;

public class Runner {
    private static Logger LOGGER = LogManager.getLogger(Runner.class);
    public static void main(String[] args) {

        String text2 ="1.\tThe if-then and if-then-else Statements\n" +
                "1.1.\tThe if-then Statement\n" +
                "The if-then statement is the most basic of all the control flow statements. It tells your program to execute a certain section of code only if a particular test evaluates to true. For example, the Bicycle class could allow the brakes to decrease the bicycle's speed only if the bicycle is already in motion. One possible implementation of the applyBrakes method could be as follows:\n" +
                "The if-then statement is the most basic of all the control flow statements. It tells your program to execute a certain section of code only if a particular test evaluates to true. For example, the Bicycle class could allow the brakes to decrease the bicycle's speed only if the bicycle is already in motion. One possible implementation of the applyBrakes method could be as follows:\n" +
                "\n" +
                "void applyBrakes() {\n" +
                "    // the \"if\" clause: bicycle must be moving\n" +
                "    if (isMoving){ \n" +
                "        // the \"then\" clause: decrease current speed\n" +
                "        currentSpeed--;\n" +
                "    }\n" +
                "}\n" +
                "If this test evaluates to false (meaning that the bicycle is not in motion), control jumps to the end of the if-then statement.\n" +
                "In addition, the opening and closing braces are optional, provided that the \"then\" clause contains only one statement:\n" +
                "void applyBrakes() {\n" +
                "    // same as above, but without braces \n" +
                "    if (isMoving)\n" +
                "        currentSpeed--;\n" +
                "}\n" +
                "Deciding when to omit the braces is a matter of personal taste. Omitting them can make the code more brittle. If a second statement is later added to the \"then\" clause, a common mistake would be forgetting to add the newly required braces. The compiler cannot catch this sort of error; you'll just get the wrong results.\n" +
                "1.2.\tThe if-then-else Statement\n" +
                "The if-then-else statement provides a secondary path of execution when an \"if\" clause evaluates to false. You could use an if-then-else statement in the applyBrakes method to take some action if the brakes are applied when the bicycle is not in motion. In this case, the action is to simply print an error message stating that the bicycle has already stopped.\n" +
                "void applyBrakes() {\n" +
                "    if (isMoving) {\n" +
                "        currentSpeed--;\n" +
                "    } else {\n" +
                "        System.err.println(\"The bicycle has already stopped!\");\n" +
                "    } \n" +
                "}\n" +
                "The following program, IfElseDemo, assigns a grade based on the value of a test score: an A for a score of 90% or above, a B for a score of 80% or above, and so on.\n" +
                "\n" +
                "class IfElseDemo {\n" +
                "    public static void main(String[] args) {\n" +
                "        int testscore = 76;\n" +
                "        char grade;\n" +
                "        if (testscore >= 90) {\n" +
                "            grade = 'A';\n" +
                "        } else if (testscore >= 80) {\n" +
                "            grade = 'B';\n" +
                "        } else if (testscore >= 70) {\n" +
                "            grade = 'C';\n" +
                "        } else if (testscore >= 60) {\n" +
                "            grade = 'D';\n" +
                "        } else {\n" +
                "            grade = 'F';\n" +
                "        }\n" +
                "        System.out.println(\"Grade = \" + grade);\n" +
                "    }\n" +
                "}\n" +
                "The output from the program is:\n" +
                "    Grade = C\n" +
                "You may have noticed that the value of testscore can satisfy more than one expression in the compound statement: 76 >= 70 and 76 >= 60. However, once a condition is satisfied, the appropriate statements are executed (grade = 'C';) and the remaining conditions are not evaluated.\n" +
                "Deciding when to omit the braces is a matter of personal taste. Omitting them can make the code more brittle. If a second statement is later added to the \"then\" clause, a common mistake would be forgetting to add the newly required braces. The compiler cannot catch this sort of error; you'll just get the wrong results.\n" +
                "1.2.\tThe if-then-else Statement\n" +
                "The if-then-else statement provides a secondary path of execution when an \"if\" clause evaluates to false. You could use an if-then-else statement in the applyBrakes method to take some action if the brakes are applied when the bicycle is not in motion. In this case, the action is to simply print an error message stating that the bicycle has already stopped.\n" +
                "The if-then statement is the most basic of all the control flow statements. It tells your program to execute a certain section of code only if a particular test evaluates to true. For example, the Bicycle class could allow the brakes to decrease the bicycle's speed only if the bicycle is already in motion. One possible implementation of the applyBrakes method could be as follows:\n" +
                "The if-then statement is the most basic of all the control flow statements. It tells your program to execute a certain section of code only if a particular test evaluates to true. For example, the Bicycle class could allow the brakes to decrease the bicycle's speed only if the bicycle is already in motion.\n";

            CompositeUnitEntity parsedText = (CompositeUnitEntity) ParserLogic.parse(text2);
            System.out.println(parsedText.getChildTextUnits());

    }
}
