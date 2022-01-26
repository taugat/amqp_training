package fr.lernejo.chat;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class ChatMessageRepository
{

    private List<String> lastTenMessage = new ArrayList<>();

    public void addChatMessage(String message)
    {
        lastTenMessage.add(message);
    }

    public List<String> getLastTenMessages()
    {
        return lastTenMessage.stream().limit(10).collect(Collectors.toList());
    }
}
