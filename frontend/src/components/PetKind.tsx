"use client";

import classNames from "classnames";
import { BiLogoBaidu } from "react-icons/bi";
import { LiaCatSolid } from "react-icons/lia";
import { FaDog } from "react-icons/fa";
import { PET_SPECIES } from "@/constants";
import { useRouter } from "next/navigation";

export interface IPetKind {
  id?: string;
  name: string;
  specie?: string;
  active?: boolean;
}

export const PetKind = ({ name, specie, active = false, id }: IPetKind) => {
  const router = useRouter();
  const params = new URLSearchParams();
  const cardClasses = classNames(
    "cursor-pointer p-8 rounded-lg shadow-lg w-[200px] flex flex-col gap-2 items-center justify-center",
    {
      "bg-[#FFAC31]": active,
      "bg-[#FFCD82]": !active,
    }
  );

  const onHandleKindFilter = () => {
    if (id) params.set("SPECIE_ID", id);

    const queryString = params.toString();
    const newUrl = `${window.location.pathname}?${queryString}`;
    router.push(newUrl);
  };
  return (
    <aside className={cardClasses} onClick={onHandleKindFilter}>
      {specie === PET_SPECIES.ALL && <BiLogoBaidu size={60} />}
      {specie === PET_SPECIES.CAT && <LiaCatSolid size={60} />}
      {specie === PET_SPECIES.DOG && <FaDog size={60} />}
      <p className="text-2xl font-bold">{name}</p>
    </aside>
  );
};
