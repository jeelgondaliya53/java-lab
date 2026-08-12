public class Chat {
    public static String fill(String[] log,String keyword)
    {
        int count=0;
        StringBuilder word=new StringBuilder();

        for (String line: log) {
            String[] parts = line.split(" ", 3);

            if (parts.length < 3) {
                continue;
            }
            String time=parts[0];
            String user=parts[1];
            String message=parts[2];

            if (message.toLowerCase().contains(keyword.toLowerCase())) {
                count++;

                word.append(time)
                    .append(" ")
                    .append(user)
                    .append(": ")
                    .append(message)
                    .append("\n");
            }
        }

        return "Matches: " + count + "\nword " + word;
    }
    
}
