import { IPetParams } from "@/app/mascotas/page";
import { IPet, Pet } from "./Pet";
import { PetFoundNumber } from "./PetFoundNumber";
import { getPets } from "@/actions/pets";

export const PetGrid = async ({ SEX, NAME, SPECIE_ID }: IPetParams) => {
  const params: { [key: string]: string } = {};

  if (SEX) params.sexo = SEX;
  if (NAME) params.nombre = NAME;
  if (SPECIE_ID) params.especieId = SPECIE_ID;
  const queryParams = new URLSearchParams(params as any).toString();

  const { pets, isOk } = await getPets(queryParams);
  if (isOk) {
    return (
      <>
        <PetFoundNumber cant={pets.length} />
        <section className="grid grid-cols-3 gap-12 w-full">
          {pets.map((pet: IPet, i: number) => (
            <Pet {...pet} key={i} />
          ))}
        </section>
      </>
    );
  }
};
