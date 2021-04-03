export class IdGenerator {
  private static currentId = 0;

  public static nextId(): number {
    return IdGenerator.currentId++;
  }

  protected static getCurrentId(): number {
    return IdGenerator.currentId;
  }
}
