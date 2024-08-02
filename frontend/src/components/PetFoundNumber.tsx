"use client";

import { useRouter, useSearchParams } from "next/navigation";

interface IFoundNumber {
  cant: number;
}
export const PetFoundNumber = ({ cant }: IFoundNumber) => {
  const router = useRouter();
  const searchParams = useSearchParams();
  const params = new URLSearchParams(searchParams);

  const specieId = params.get("SPECIE_ID") || "";
  const name = params.get("NAME") || "";
  const sex = params.get("SEX") || "";

  const clearFilters = () => {
    const newUrl = `${window.location.pathname}`;
    router.push(newUrl);
  };

  return (
    <div className="flex justify-between">
      <p className="text-3xl font-medium">{cant} mascotas encontradas</p>
      {(specieId || name || sex) && (
        <button onClick={clearFilters} className="btn btn-md text-white">
          Limpiar Filtro
        </button>
      )}
    </div>
  );
};
