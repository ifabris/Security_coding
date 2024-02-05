package hr.algebra.Security.serialization;

import hr.algebra.Security.model.Player;
import hr.algebra.Security.request.PlayerRequest;
import hr.algebra.Security.request.UserRequest;

public class SerializationImpl {

    private final String playerFilePath = "serializedClasses/player.ser";
    private final String userFilePath = "serializedClasses/user.ser";

    public void serialize() {
        PlayerRequest playerRequest = new PlayerRequest();
        UserRequest userRequest = new UserRequest();


        Serializer.serialize(playerRequest, playerFilePath);
     //   Serializer.serialize(userRequest, playerFilePath);
    }

    public void deserialize() {
        PlayerRequest playerRequest = (PlayerRequest) Serializer.deserialize(playerFilePath);
    }

}
