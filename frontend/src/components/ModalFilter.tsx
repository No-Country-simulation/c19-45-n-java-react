"use client";

import { MODAL, PET_SEX_ALL } from "@/constants";
import { Input, ModalWrapper, Select } from ".";
import { useModalStore } from "@/store";
import { useRouter } from "next/navigation";
import { useState } from "react";

export const ModalFilter = () => {
  const router = useRouter();
  const toggle = useModalStore((state) => state.toggle);
  const [name, setName] = useState("");
  const [sex, setSex] = useState("");

  const onChange = (value: string, query: string) => {
    if (query === "SEX") {
      setSex(value);
    } else if (query === "NAME") {
      setName(value);
    }
  };

  const onHandleFilter = () => {
    const params = new URLSearchParams();

    if (sex) params.set("SEX", sex);
    if (name) params.set("NAME", name);

    const queryString = params.toString();
    const newUrl = `${window.location.pathname}?${queryString}`;
    router.push(newUrl);
  };

  return (
    <ModalWrapper name={MODAL.FILTER} title="Filtros">
      <div className="w-[500px] flex flex-col gap-6">
        <Input
          label="Nombres*"
          type="text"
          placeholder="Ingresar nombres"
          name="NAME"
          onChange={onChange}
        />
        <Select
          label="Sexo*"
          placeholder="Seleccione sexo"
          options={PET_SEX_ALL}
          onChange={onChange}
          name="SEX"
          value=""
        />
        <div
          className="flex justify-center mt-5"
          onClick={() => toggle({ name: "", isOpen: false })}
        >
          <button
            onClick={onHandleFilter}
            className="btn btn-active text-white btn-lg w-56 shadow-lg text-2xl"
          >
            Filtrar
          </button>
        </div>
      </div>
    </ModalWrapper>
  );
};
