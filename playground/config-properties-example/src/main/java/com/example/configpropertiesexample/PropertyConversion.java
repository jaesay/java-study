package com.example.configpropertiesexample;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.convert.DataSizeUnit;
import org.springframework.boot.convert.DurationUnit;
import org.springframework.util.unit.DataSize;
import org.springframework.util.unit.DataUnit;

@ConfigurationProperties(prefix = "conversion")
@Getter
@Setter
public class PropertyConversion {
  private Duration timeInDefaultUnit;
  private Duration timeInNano;

  @DurationUnit(ChronoUnit.DAYS)
  private Duration timeInDays;

  private DataSize sizeInDefaultUnit;

  private DataSize sizeInGB;

  @DataSizeUnit(DataUnit.TERABYTES)
  private DataSize sizeInTB;

  private Employee employee;
}
