package dk.htr.games.minmax.four_in_row.config;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@RequiredArgsConstructor
@Configuration
@ConfigurationProperties(prefix = "dimensions")
public class GameDimensions {
    private int nrOfColumns;
    private int nrOfRows;
    private int lengthToWin;
}
