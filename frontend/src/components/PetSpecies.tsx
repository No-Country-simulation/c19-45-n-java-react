import { PET_SPECIES } from "@/constants";
import { PetFilters } from "./PetFilters";
import { PetKind } from "./PetKind";
import { petSpecies } from "@/actions/pets";

interface IPetSpecies {
  currentSpecie: string;
}
export const PetSpecies = async ({ currentSpecie }: IPetSpecies) => {
  const { isOk, species } = await petSpecies();

  if (isOk) {
    return (
      <div>
        <PetFilters />
        <div className="flex gap-8 mt-6">
          <PetKind
            name="Todos"
            specie={PET_SPECIES.ALL}
            active={currentSpecie === undefined}
          />
          {species.map((kind: any, i: number) => {
            const kindUppercase = kind.nombre?.toUpperCase();

            return (
              <PetKind
                key={i}
                id={kind.id}
                active={Number(currentSpecie) === kind.id}
                name={kindUppercase === "CAT" ? "Gato" : "Perro"}
                specie={
                  kindUppercase === "CAT" ? PET_SPECIES.CAT : PET_SPECIES.DOG
                }
              />
            );
          })}
        </div>
      </div>
    );
  }
};
