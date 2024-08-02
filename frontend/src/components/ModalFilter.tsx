"use client";

import { MODAL, PET_SEX_ALL, PET_SPECIES_ALL } from "@/constants";
import { Input, ModalWrapper, Select } from ".";
import { useModalStore } from "@/store";

export const ModalFilter = () => {
  const toggle = useModalStore((state) => state.toggle);
  return (
    <ModalWrapper name={MODAL.FILTER} title="Filtros">
      <div className="w-[500px] flex flex-col gap-6">
        <Input label="Nombres*" type="text" placeholder="Ingresar nombres" />
        <Select
          label="Especie*"
          placeholder="Seleccione especie"
          options={PET_SPECIES_ALL}
        />
        <Select
          label="Sexo*"
          placeholder="Seleccione sexo"
          options={PET_SEX_ALL}
        />
        <div
          className="flex justify-center mt-5"
          onClick={() => toggle({ name: "", isOpen: false })}
        >
          <button className="btn btn-active text-white btn-lg w-56 shadow-lg text-2xl">
            Filtrar
          </button>
        </div>
      </div>
    </ModalWrapper>
  );
};
