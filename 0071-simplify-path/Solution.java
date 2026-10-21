class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] arr = path.split("/");
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals("") || arr[i].equals(".")) {
                continue;
            }
            else if (arr[i].equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            }
            else {
                stack.push(arr[i]);
            }
        }

        String ans = "";
        for (int i = 0; i < stack.size(); i++) {
            ans += "/" + stack.get(i);
        }

        if (ans.equals("")) {
            return "/";
        }

        return ans;
    }
}