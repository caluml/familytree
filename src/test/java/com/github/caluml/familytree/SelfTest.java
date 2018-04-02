package com.github.caluml.familytree;

import org.junit.Test;

import static com.github.caluml.familytree.Sex.FEMALE;
import static com.github.caluml.familytree.Sex.MALE;
import static org.assertj.core.api.Assertions.assertThat;

public class SelfTest {

  @Test
  public void Mothers_son() {
    assertThat(new Me(MALE).mothers().son()).isEqualTo("brother");
  }

  @Test
  public void Fathers_son() {
    assertThat(new Me(MALE).fathers().son()).isEqualTo("brother");
  }

  @Test
  public void Mothers_daughter() {
    assertThat(new Me(FEMALE).mothers().daughter()).isEqualTo("sister");
  }

  @Test
  public void Fathers_daughter() {
    assertThat(new Me(FEMALE).fathers().daughter()).isEqualTo("sister");
  }


}
