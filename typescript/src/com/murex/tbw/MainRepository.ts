import { Repository } from "./storage/Repository";
import { JsonRepository } from "./storage/JsonRepository";

export class MainRepository {
  private static runningRepository: Repository;

  // eslint-disable-next-line @typescript-eslint/no-empty-function
  private constructor() {}

  public static configuredRepository(): Repository {
    if (!MainRepository.runningRepository) {
      MainRepository.runningRepository = new JsonRepository();
    }

    return MainRepository.runningRepository;
  }

  /* Working effectively with Legacy Code
   * https://www.goodreads.com/book/show/44919.Working_Effectively_with_Legacy_Code
   */
  // TESTING ONLY
  public static override(newRepository: Repository): void {
    MainRepository.runningRepository = newRepository;
  }

  // TESTING ONLY
  public static reset(): void {
    MainRepository.runningRepository = new JsonRepository();
  }
}
