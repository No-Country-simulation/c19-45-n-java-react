import { ModalWrapper } from ".";
import { Member } from "./Member";
import { MODAL } from "@/app/_constants";
import { team_members } from "@/app/_data";

export const ModalTeam = () => {
  return (
    <ModalWrapper
      name={MODAL.TEAMS}
      title="c19-45-n-java-react"
      subtitle="Integrantes de Equipo"
    >
      <div className="grid grid-cols-2 gap-4 h-[400px] overflow-auto">
        {team_members.map((member, i) => (
          <Member {...member} key={i} />
        ))}
      </div>
    </ModalWrapper>
  );
};
