package com.github.caluml.familytree;

import org.junit.Test;

import static com.github.caluml.familytree.Sex.MALE;
import static org.assertj.core.api.Assertions.assertThat;

public class DescendantTest {

  @Test
  public void Son() {
    assertThat(new Me(MALE).son()).isEqualTo("son");
  }

  @Test
  public void Daughter() {
    assertThat(new Me(MALE).daughter()).isEqualTo("daughter");
  }

  @Test
  public void Grandson() {
    assertThat(new Me(MALE).sons().son()).isEqualTo("grand-son");
  }

  @Test
  public void Granddaughter() {
    assertThat(new Me(MALE).sons().daughter()).isEqualTo("grand-daughter");
  }

  @Test
  public void Great_grandson() {
    assertThat(new Me(MALE).sons().daughters().son()).isEqualTo("great-grand-son");
  }
  @Test
  public void Great_granddaughter() {
    assertThat(new Me(MALE).sons().daughters().daughter()).isEqualTo("great-grand-daughter");
  }

}
