import io.lettuce.core.RedisURI;
import io.lettuce.core.cluster.RedisClusterClient;
import io.lettuce.core.cluster.api.StatefulRedisClusterConnection;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        try (RedisClusterClient client = RedisClusterClient.create(
                List.of(
                        RedisURI.create("redis://localhost:7000"),
                        RedisURI.create("redis://localhost:7001"),
                        RedisURI.create("redis://localhost:7002")
                )
        )) {
            StatefulRedisClusterConnection<String, String> connection = client.connect();
            connection.sync().set("k1", "v1");
            connection.sync().set("k2", "v2");
            connection.sync().set("k3", "v3");
            connection.sync().set("k4", "v4");
            connection.sync().set("k5", "v5");
        }
    }

}
