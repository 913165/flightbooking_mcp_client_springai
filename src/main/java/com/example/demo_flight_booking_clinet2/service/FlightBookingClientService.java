package com.example.demo_flight_booking_clinet2.service;

import com.example.demo_flight_booking_clinet2.model.FlightBooking;
import com.example.demo_flight_booking_clinet2.model.FlightResponseMessage;
import io.modelcontextprotocol.client.McpSyncClient;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.model.Generation;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.ai.converter.BeanOutputConverter;
import org.springframework.ai.mcp.SyncMcpToolCallbackProvider;
import org.springframework.ai.tool.ToolCallback;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class FlightBookingClientService {
    ChatClient chatClient;

    public FlightBookingClientService(List<McpSyncClient> mcpSyncClients, ChatClient.Builder chatClientBuilder) {

        System.out.println("Spring Ai MCP Client Example Application is running!");
        System.out.println("list of mcpSyncClients: " + mcpSyncClients);
        McpSyncClient mspclient = mcpSyncClients.getFirst();
        System.out.println("mspclient: " + mspclient.listTools());
        SyncMcpToolCallbackProvider toolCallbackProvider = new SyncMcpToolCallbackProvider(mcpSyncClients);
        ToolCallback[] toolCallbacks = toolCallbackProvider.getToolCallbacks();
        for (ToolCallback toolCallback : toolCallbacks) {
            System.out.println("Tool Callback getToolDefinition: " + toolCallback.getToolDefinition());
        }

        this.chatClient = chatClientBuilder
                .defaultToolCallbacks(toolCallbackProvider)
                .build();

    }

    public FlightResponseMessage processInput(String userInput) {
        FlightResponseMessage flightResponseMessage = chatClient
                .prompt(userInput)

                .call()
                .entity(new ParameterizedTypeReference<FlightResponseMessage>() {
                });
        return flightResponseMessage;
    }
}
