package command;

import io.vavr.collection.List;

public class FakeOutputAdapter {
    List<String> allOutputs = List.empty();

    public String getAllOutputs(){
        return allOutputs.mkString("\n");
    }

    public void sendOut(String message) {
        allOutputs = allOutputs.append(message);
    }
}
