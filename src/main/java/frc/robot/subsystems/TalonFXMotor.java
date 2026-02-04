package frc.robot.subsystems;

import java.util.function.DoubleSupplier;

import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.controls.DutyCycleOut;
import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class TalonFXMotor extends SubsystemBase {
    private final TalonFX talonFx;
    private final TalonFXConfiguration talonFxConfig = new TalonFXConfiguration();
    private final DutyCycleOut talonFxOut = new DutyCycleOut(0.0);   
    private final int myId;

    public TalonFXMotor(int id) {
        myId = id;
        talonFx = new TalonFX(id);
        talonFx.getConfigurator().apply(talonFxConfig);
    }

    public Command setOutput(DoubleSupplier output) {
        return Commands.run(() -> {
            talonFxOut.Output = output.getAsDouble();   
            talonFx.setControl(talonFxOut);   
        },
        this
            );
    }

    public double getRPM(){
        return talonFx.getVelocity().getValueAsDouble()*60;
    }

    @Override
    public void periodic() {
        SmartDashboard.putNumber(myId + " rpm", getRPM());
    }

}
