package com.github.caluml.familytree;

import static com.github.caluml.familytree.Greats.great;
import static com.github.caluml.familytree.Ordinals.ordinal;

public class Me implements Modifier, Final {

  private Sex sex;
  private int ancestors;
  private int descendants;
  private int across;
  private boolean inlaw;

  public Me(Sex sex) {
    this.sex = sex; // Unused currently
  }

  @Override
  public Me mothers() {
    ancestors++;
    return this;
  }

  @Override
  public Me fathers() {
    ancestors++;
    return this;
  }

  @Override
  public Me brothers() {
    across++;
    return this;
  }

  @Override
  public Me sisters() {
    across++;
    return this;
  }

  @Override
  public Me sons() {
    descendants++;
    return this;
  }

  @Override
  public Me daughters() {
    descendants++;
    return this;
  }

  @Override
  public Me spouses() {
    across++;
    inlaw = true;
    return this;
  }

  @Override
  public String son() {
    descendants++;
    if (ancestors == 0 && descendants == 1 && across == 1) {
      return "nephew";
    }
    if (ancestors == 1 && descendants == 1 && across == 0) {
      return "brother";
    }

    if (ancestors == 0 && across == 0) {
      return great(descendants) + "son";
    }

    if (across == 1 && ancestors == descendants) {
      return cousin(ancestors);
    }

    if (across == 1 && ancestors == descendants - 1) {
      return cousinOnceRemoved(ancestors);
    }

    if (ancestors == 1 && descendants == 3 && across == 1) {
      return "first-cousin-twice-removed";
    }
    throw new RuntimeException(message(ancestors, descendants, across));
  }

  @Override
  public String daughter() {
    descendants++;
    if (ancestors == 0 && descendants == 1 && across == 1) {
      return "niece";
    }
    if (ancestors == 1 && descendants == 1 && across == 0) {
      return "sister";
    }

    if (ancestors == 0 && across == 0) {
      return great(descendants) + "daughter";
    }

    if (across == 1 && ancestors == descendants) {
      return cousin(ancestors);
    }

    if (across == 1 && ancestors == descendants - 1) {
      return cousinOnceRemoved(ancestors);
    }

    if (ancestors == 1 && descendants == 3 && across == 1) {
      return "first-cousin-twice-removed";
    }
    throw new RuntimeException(message(ancestors, descendants, across));
  }

  @Override
  public String mother() {
    if (inlaw) {
      return "mother-in-law";
    }
    if (ancestors == 0 && descendants == 0 && across == 1) {
      return "mother";
    }
    if (ancestors == 0 && descendants == 0 && across == 0) {
      return "mother";
    }
    if (ancestors == 1 && descendants == 0 && across == 0) {
      return "grand-mother";
    }
    if (ancestors == 2 && descendants == 0 && across == 0) {
      return "great-grand-mother";
    }
    throw new RuntimeException(message(ancestors, descendants, across));
  }

  @Override
  public String father() {
    if (inlaw) {
      return "father-in-law";
    }
    if (ancestors == 0 && descendants == 0 && across == 1) {
      return "father";
    }

    if (ancestors == 0 && descendants == 0 && across == 0) {
      return "father";
    }
    if (ancestors == 1 && descendants == 0 && across == 0) {
      return "grand-father";
    }
    if (ancestors == 2 && descendants == 0 && across == 0) {
      return "great-grand-father";
    }
    throw new RuntimeException(message(ancestors, descendants, across));
  }

  @Override
  public String brother() {
    if (ancestors == 0) {
      return "brother";
    }
    if (ancestors == 1 && descendants == 0 && across == 0) {
      return "uncle";
    }
    throw new RuntimeException(message(ancestors, descendants, across));
  }

  @Override
  public String sister() {
    if (ancestors == 0) {
      return "sister";
    }
    if (ancestors == 1 && descendants == 0 && across == 0) {
      return "aunt";
    }
    throw new RuntimeException(message(ancestors, descendants, across));
  }

  @Override
  public String spouse(Sex sex) {
    if (sex == Sex.MALE) {
      return "brother-in-law";
    }
    return "sister-in-law";
  }

  private String message(int ancestors, int descendants, int across) {
    return String.format("ancestors == %d && descendants == %d && across == %d", ancestors, descendants, across);
  }

  private String cousin(int ancestors) {
    return ordinal(ancestors) + "-cousin";
  }

  private String cousinOnceRemoved(int ancestors) {
    if (ancestors == 1) {
      return "first-cousin-once-removed";
    }
    if (ancestors == 2) {
      return "second-cousin-once-removed";
    }
    if (ancestors == 3) {
      return "third-cousin-once-removed";
    }
    throw new RuntimeException(message(ancestors, descendants, across));
  }
}