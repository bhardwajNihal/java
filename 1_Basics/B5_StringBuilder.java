/*
🧠 CONCEPT: String vs StringBuilder in Java

- String is immutable: Once created, it cannot be changed.
- StringBuilder is mutable: You can modify the same object (append, insert, reverse, etc.).

Why use StringBuilder?
- More memory and performance efficient than String when doing lots of modifications.
- Especially useful in loops or string manipulation-heavy logic.

Does modifying StringBuilder affect the original String used to create it?
❌ NO — because StringBuilder makes a **copy** of the characters from the original String.
They are separate in memory.

Example: 
    String str = "abc";
    StringBuilder sb = new StringBuilder(str);
    sb.reverse();
    Now:
      - sb → "cba"
      - str → "abc" (unchanged)
*/


public class B5_StringBuilder {

    public static void main(String[] args) {

        // Step 1: Create a String (immutable)
        String str = "abc";

        // Step 2: Create a StringBuilder using the String
        // This creates a new internal character array and copies "abc" into it
        StringBuilder sb = new StringBuilder(str);

        // Step 3: Reverse the StringBuilder (modifies its internal buffer)
        sb.reverse();

        // Step 4: Print both sb and str
        System.out.println("StringBuilder (reversed): " + sb);  // Output: cba
        System.out.println("Original String: " + str);          // Output: abc

        /*
        Explanation:
        - sb.reverse() only affects sb, not str.
        - Because str is immutable and StringBuilder has its own internal char array.
        */

        // ----------------------------- Extra StringBuilder Features -----------------------------

        // Append text to the end
        sb.append("XYZ");
        System.out.println("After append: " + sb);  // Output: cbaXYZ

        // Insert text at a specific position
        sb.insert(3, "--");
        System.out.println("After insert: " + sb);  // Output: cba--XYZ

        // Replace characters between given indices
        sb.replace(0, 3, "123");
        System.out.println("After replace: " + sb); // Output: 123--XYZ

        // Delete characters between given indices
        sb.delete(3, 5);
        System.out.println("After delete: " + sb);  // Output: 123XYZ

        // Convert back to String
        String result = sb.toString();
        System.out.println("Converted to String: " + result);   // Output: 123XYZ

        // Reverse again
        sb.reverse();
        System.out.println("Final reversed sb: " + sb);         // Output: ZYX321
    }
}


/*
✅ Key Takeaways:

1. StringBuilder is efficient and preferred for string manipulations.
2. StringBuilder and String are separate in memory even if initialized with the same content.
3. Changes in StringBuilder do not affect the original String.
4. Use toString() to convert StringBuilder back into a normal String.

🏁 Use Case: Building strings dynamically, especially in loops or processing large strings.

🔁 Common Methods:
- append(), insert(), replace(), delete(), reverse(), toString()

🆚 StringBuffer vs StringBuilder:
- StringBuffer is thread-safe (synchronized), but slower.
- StringBuilder is not thread-safe but faster (use in single-threaded apps).
*/