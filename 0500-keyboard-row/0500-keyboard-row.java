class Solution {
    public String[] findWords(String[] words) {
        String[] rows = {
            "qwertyuiop",
            "asdfghjkl",
            "zxcvbnm"
        };

        List<String> result = new ArrayList<>();

        for (String word : words) {
            String lower = word.toLowerCase();

            for (String row : rows) {
                boolean valid = true;

                for (char c : lower.toCharArray()) {
                    if (row.indexOf(c) == -1) {
                        valid = false;
                        break;
                    }
                }

                if (valid) {
                    result.add(word);
                    break;
                }
            }
        }

        return result.toArray(new String[0]);
    }
}