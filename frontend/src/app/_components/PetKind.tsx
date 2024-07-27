import classNames from "classnames";
import { BiLogoBaidu } from "react-icons/bi";
import { LiaCatSolid } from "react-icons/lia";
import { FaDog } from "react-icons/fa";
import { PET_SPECIES } from "@/app/_constants";

interface IPetKind {
  name: string;
  specie?: string;
  active?: boolean;
}

export const PetKind = ({ name, specie, active = false }: IPetKind) => {
  const cardClasses = classNames(
    "cursor-pointer p-8 rounded-lg shadow-lg w-[200px] flex flex-col gap-2 items-center justify-center",
    {
      "bg-[#FFAC31]": active,
      "bg-[#FFCD82]": !active,
    }
  );
  return (
    <aside className={cardClasses}>
      {specie === PET_SPECIES.ALL && <BiLogoBaidu size={60} />}
      {specie === PET_SPECIES.CAT && <LiaCatSolid size={60} />}
      {specie === PET_SPECIES.DOG && <FaDog size={60} />}
      <p className="text-2xl font-bold">{name}</p>
    </aside>
  );
};
