import { IPet, Pet } from "./Pet";
import { PetFoundNumber } from "./PetFoundNumber";
import { getPets } from "@/actions/pets";

export const PetGrid = async () => {
  const { pets, isOk } = await getPets();
  if (isOk) {
    return (
      <>
        <PetFoundNumber />
        <section className="grid grid-cols-3 gap-12 w-full">
          {pets.map((pet: IPet) => (
            <Pet {...pet} />
          ))}
        </section>
      </>
    );
  }
};
