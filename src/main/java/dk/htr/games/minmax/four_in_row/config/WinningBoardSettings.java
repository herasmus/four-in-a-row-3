package dk.htr.games.minmax.four_in_row.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "winning.board.file")
public class WinningBoardSettings {
    private boolean saveWinningBoards;
    private String winningBoardsFilePath;// = "c:/Viden/winning.wb";
}
