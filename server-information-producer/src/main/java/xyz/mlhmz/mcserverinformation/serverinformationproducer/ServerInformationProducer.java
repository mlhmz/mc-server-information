package xyz.mlhmz.mcserverinformation.serverinformationproducer;

import lombok.Getter;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitTask;
import redis.clients.jedis.JedisPool;
import xyz.mlhmz.mcserverinformation.serverinformationproducer.commands.ServerInformationProducerCommand;
import xyz.mlhmz.mcserverinformation.serverinformationproducer.fetcher.BukkitServerInformationFetcher;
import xyz.mlhmz.mcserverinformation.serverinformationproducer.publisher.RedisInformationPublisher;

import java.util.Objects;

public final class ServerInformationProducer extends JavaPlugin {
    public static final String SIP_COMMAND_KEY = "sip";
    private BukkitTask task;
    @Getter
    private String redisHost;
    @Getter
    private int redisPort;
    @Getter
    private String redisChannel;

    @Override
    public void onEnable() {
        // Plugin startup logic
        createCommands();
        this.saveDefaultConfig();
        executeInformationBukkitTask();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public void reload() {
        this.reloadConfig();
        task.cancel();
        executeInformationBukkitTask();
    }

    private void createCommands() {
        Objects.requireNonNull(this.getCommand(SIP_COMMAND_KEY))
                .setExecutor(new ServerInformationProducerCommand(this));
    }

    private void executeInformationBukkitTask() {
        redisHost = this.getConfig().getString("redis.host", "localhost");
        redisPort = this.getConfig().getInt("redis.port", 6379);
        redisChannel = this.getConfig().getString("redis.channel", "server-info");
        Runnable informationTaskExecution = () -> {
            try (JedisPool jedisPool = new JedisPool(redisHost, redisPort)) {
                InformationTask informationTask = new InformationTask(
                        new BukkitServerInformationFetcher(this.getServer()),
                        new RedisInformationPublisher(jedisPool.getResource(), redisChannel, this)
                );
                informationTask.execute();
            }
        };
        task = this.getServer().getScheduler().runTaskTimer(this, informationTaskExecution, 1000, 1000);
    }

}
