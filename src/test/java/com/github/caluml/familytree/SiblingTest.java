package com.github.caluml.familytree;

import org.junit.Test;

import static com.github.caluml.familytree.Sex.MALE;
import static org.assertj.core.api.Assertions.assertThat;

public class SiblingTest {

  @Test
  public void Brother() {
    assertThat(new Me(MALE).brother()).isEqualTo("brother");
  }

  @Test
  public void Sister() {
    assertThat(new Me(MALE).sister()).isEqualTo("sister");
  }
}
