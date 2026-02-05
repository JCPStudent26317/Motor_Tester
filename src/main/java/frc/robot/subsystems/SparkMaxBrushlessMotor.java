package frc.robot.subsystems;

import java.util.function.DoubleSupplier;

import com.revrobotics.PersistMode;
import com.revrobotics.ResetMode;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.config.SparkMaxConfig;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class SparkMaxBrushlessMotor extends SubsystemBase {
    private final SparkMax sparkMax;
    private final SparkMaxConfig sparkMaxConfig = new SparkMaxConfig();
    private final int myId;

    public SparkMaxBrushlessMotor(int id) {
        myId = id;
        sparkMax = new SparkMax(id, SparkMax.MotorType.kBrushless);
        sparkMax.configure(sparkMaxConfig, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
    }

    public Command setOutput(DoubleSupplier output) {
        return Commands.run(() -> {
            sparkMax.set(output.getAsDouble());
        },
        this
            );
    }

    public double getRPM(){
        return sparkMax.getEncoder().getVelocity();
    }

    @Override
    public void periodic() {
        SmartDashboard.putNumber(myId + " rpm", getRPM());
    }
}
