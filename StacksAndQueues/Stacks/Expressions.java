package StacksAndQueues.Stacks;

import java.util.Stack;

public class Expressions {
    
// ## 📘 Prefix, Infix & Postfix Expressions (with Stacks)

// ### 1. Infix (Normal human way)

// * Operator is **between operands**.
// * Example: `A + B * C`
// * **Problem**: Needs precedence rules & parentheses to avoid ambiguity.

// ### 2. Prefix (Polish Notation)

// * Operator comes **before operands**.
// * Example: `+ A * B C`
// * Means: `A + (B * C)`
// * **Advantage**: No parentheses needed.

// ### 3. Postfix (Reverse Polish Notation)

// * Operator comes **after operands**.
// * Example: `A B C * +`
// * Means: `A + (B * C)`
// * **Advantage**: Easy evaluation using a stack.

// ---

// ## ✅ Why do we need Prefix/Postfix?

// * Computers don’t like ambiguity → infix is hard to parse.
// * Postfix/prefix = **clear, unambiguous order**.
// * Postfix is widely used for **stack evaluation** → calculators & compilers often convert infix → postfix before evaluating.

// ---

// ## ⚡ Postfix Evaluation (Stack Method)

// Expression: `2 3 4 * +`

// 1. Push 2 → \[2]
// 2. Push 3 → \[2, 3]
// 3. Push 4 → \[2, 3, 4]
// 4. See `*` → pop 4 & 3 → compute `3*4=12` → push → \[2, 12]
// 5. See `+` → pop 12 & 2 → compute `2+12=14` → push → \[14]

// ✅ Result = 14

// ---

// ## 📝 Summary

// * **Infix** → What humans write (needs precedence/parentheses).
// * **Prefix** → Operator before (no parentheses).
// * **Postfix** → Operator after (no parentheses, easy with stack).
// * **Use case**: Compilers & calculators often internally convert infix → postfix to evaluate expressions efficiently.



}
